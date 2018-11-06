package atj;

import java.io.IOException;
import java.util.Optional;
import static java.util.Optional.ofNullable;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class TempConverterServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private static final String paramConvertDir = "convDir";
	private static final String paramConvertDirDefValue = "C2F";
	private static final String paramTemp = "temp";
	private static final String paramErrMsg = "err";	
	private static final String paramResult = "res";		
	private static final String resultPage = "index.jsp";		

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tempDir = ofNullable(request.getParameter(paramConvertDir)).orElse(paramConvertDirDefValue);
		String tempIn = ofNullable(request.getParameter(paramTemp)).orElse("0.0"); 
		String result = "";
		String errMsg = "";
		Double temp = 0.0;
		
		try {
			temp = Double.valueOf(tempIn);
			Double tempOut = TemperatureConverterService.Convert(tempDir, temp);
			result = "Temperature after conversion is "+String.valueOf(tempOut);
		} catch(Exception e) {
			errMsg = "Conversion failed! Enter valid temperature!";
		}
		
		request.setAttribute(paramResult, result);
		request.setAttribute(paramErrMsg, errMsg);		
		request.setAttribute(paramTemp, temp);	
		request.setAttribute(paramConvertDir, tempDir);			
		RequestDispatcher requestDispatcher = request.getRequestDispatcher(resultPage);
		requestDispatcher.forward(request, response);

	}

}
