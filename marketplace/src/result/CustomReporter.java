package result;
import java.io.FileOutputStream;

import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import  org.apache.poi.hssf.usermodel.HSSFSheet;
import  org.apache.poi.hssf.usermodel.HSSFWorkbook;
import  org.apache.poi.hssf.usermodel.HSSFRow;
 
public class CustomReporter implements ITestListener, ISuiteListener, IInvokedMethodListener {
int i =0;
String total_row="";


// This belongs to ITestListener and will execute only when the test is pass
 
	public void onTestSuccess(ITestResult arg0) 
	{
		
		printTestResults(arg0);
		i++;
	}
// This belongs to ITestListener and will execute only on the event of fail test
	
	public void onTestFailure(ITestResult arg0) 
	{
		
		printTestResults(arg0);
		i++;
		
	}
// This belongs to ITestListener and will execute before the main test start (@Test)
	

	private void printTestResults(ITestResult result) 
	{
 
//		Reporter.log("Test Method resides in " + result.getTestClass().getName(), true);
		
		
		String params ="";
		String get_testcase = null;
		if (result.getParameters().length != 0) 
		{
			
			for (Object parameter : result.getParameters()) 
 			{
 				
				params += parameter.toString() + ",";
 
			}
			String[] testcase=  params.split(",");
			get_testcase=testcase[0].toString();
			
			 
		}
		
		
 
		String status = null;
 
		switch (result.getStatus()) 
		{
 
			case ITestResult.SUCCESS:
	 
				status = "Pass";
	 
				break;
	 
			case ITestResult.FAILURE:
	 
				status = "Failed";
	 
				break;
	 
			case ITestResult.SKIP:
	 
				status = "Skipped";
	 
		}
		total_row=total_row+result.getTestClass().getName()+","+get_testcase+","+ status+ "\n";

		
	}

	

	@Override
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ISuite arg0) {
		createreport(total_row);
//		System.out.print(total_row);
//		String[] row= total_row.split("\n");

//		System.out.print("\n the value of i is="+i);
		
		
	}
	private void createreport(String rowcontent) 
	{
		String[] row= total_row.split("\n");
		System.out.print("Results are as follows" +total_row);
//		System.out.print("\nlength is "+row.length + "\n");
		
	
		try {
	            String filename = "/home/users/himanshu.chand/Documents/marketplace/finalreport.xls" ;
	            @SuppressWarnings("resource")
				HSSFWorkbook workbook = new HSSFWorkbook();
	            HSSFSheet sheet = workbook.createSheet("FirstSheet"); 
	            FileOutputStream fileOut = new FileOutputStream(filename);
	            
	            
	            for(int count=0;count<=row.length;count++)
	            {	            		            	
	            	HSSFRow rowhead = sheet.createRow((short)count);
	            	if(count==0)
	            	{
	            		
	    	            rowhead.createCell(0).setCellValue("class Name");
	    	            rowhead.createCell(1).setCellValue("Test Case no");
	    	            rowhead.createCell(2).setCellValue("Result");
	            	}
	            	else
	            	{
	            	String[] column_value= row[count-1].split(",");
	            	System.out.print("\n column_value[0]" +column_value[0]);
	            	System.out.print("\n column_value[1]" +column_value[1]);
	            	System.out.print("\n column_value[2]" +column_value[2]);
	            	rowhead.createCell(0).setCellValue(column_value[0] );
	            	rowhead.createCell(1).setCellValue(column_value[1]);
	            	rowhead.createCell(2).setCellValue(column_value[2]);
	            	}
	            } 
	            workbook.write(fileOut);
	            fileOut.close();
			}
		catch ( Exception ex ) 
		{
	            System.out.println(ex);
	    }
		
	}

	@Override
	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

 }