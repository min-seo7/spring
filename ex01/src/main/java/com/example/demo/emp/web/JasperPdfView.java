//다운로드


import java.util.Collection;
import java.util.Map;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.servlet.view.AbstractView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class JasperPdfView extends AbstractView {

    private Resource reportResource;      // JRXML 위치
     
    public JasperPdfView(String path) {
    	this.reportResource = new ClassPathResource(path);
    	setContentType("application/pdf");
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws Exception {

        // 1. 데이터 소스 생성
        Collection<?> items = (Collection<?>) model.get("datas");
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(items);

        // 2. JRXML 컴파일
        JasperReport jasperReport = JasperCompileManager.compileReport(reportResource.getInputStream());

        // 3. PDF 생성
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, model, dataSource);

        // 4. PDF 브라우저 출력
        response.setContentType(getContentType());
        JasperExportManager.exportReportToPdfStream(jasperPrint, response.getOutputStream());
    }
}