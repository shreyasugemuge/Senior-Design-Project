package behaviors;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Behaviors {
	
    public static void main(String[] args) {
	
        final int NumberofStudnet = 110;
        //Behavior: Number of tests B submitted 
    	try
	{
            CSVWriter csvWriter = new CSVWriter(new FileWriter("NumberOfTest_B.csv"));

            String[] row = new String[]{"ID","Number of Test B"};
            csvWriter.writeNext(row);
			
            String[] strings = new String[2];
		for (int i = 0; i < NumberofStudnet; i++) {
	            strings[0] = Integer.toString(i+1);
                    strings[1] = Integer.toString(NumberofTestB("clean/log_" + (i+1) + ".csv"));
	            
	            csvWriter.writeNext(strings);
	        }
            csvWriter.close();
	}
        catch(Exception ee)
	{
            ee.printStackTrace();
	}
        
        //Behavior: Number of ASRs submitted 
        try
	{
            CSVWriter csvWriter = new CSVWriter(new FileWriter("NumberOfASR.csv"));

            String[] row = new String[]{"ID","Number of ASRs"};
            csvWriter.writeNext(row);
			
            String[] strings = new String[2];
		for (int i = 0; i < NumberofStudnet; i++) {
	            strings[0] = Integer.toString(i+1);
                    strings[1] = Integer.toString(NumberofASR("clean/log_" + (i+1) + ".csv"));
	            
	            csvWriter.writeNext(strings);
	        }
            csvWriter.close();
	}
        catch(Exception ee)
	{
            ee.printStackTrace();
	}
         
        
        //Behavior: Number of optional assignments submitted
        try
	{
            CSVWriter csvWriter = new CSVWriter(new FileWriter("NumberOfOptionalAssignments.csv"));

            String[] row = new String[]{"ID","Number of optinal assignments"};
            csvWriter.writeNext(row);
			
            String[] strings = new String[2];
		for (int i = 0; i < NumberofStudnet; i++) {
	            strings[0] = Integer.toString(i+1);
                    strings[1] = Integer.toString(NumberofAssignment("clean/log_" + (i+1) + ".csv"));
	            
	            csvWriter.writeNext(strings);
	        }
            csvWriter.close();
	}
        catch(Exception ee)
	{
            ee.printStackTrace();
	}
     
        
      //Behavior: Time between when unit was available and Tests B submission in days 
        try
	{
            CSVWriter csvWriter = new CSVWriter(new FileWriter("HowEarlyTestsB.csv"));

            String[] row = new String[]{"ID", "Test#1B TakenTime", "Test#2 Part#1B TakenTime", "Test#2 Part#2B TakenTime", "Test#3B TakenTime",
                "Test#4B TakenTime", "Test#5B TakenTime", "Test#6B TakenTime", "Test#7B TakenTime"};
            csvWriter.writeNext(row); 
            
            String[] Items = new String[] {"Test #1 B", "Test #2 Part #1 B", "Test #2 Part #2 B", "Test #3 B", "Test #4 B", "Test #5 B", "Test #6 B", "Test #7 B"};
            
            String[] strings = new String[Items.length + 1];
                
                for (int i = 0; i < NumberofStudnet; i++) {
                    
                    strings[0] = Integer.toString(i+1);
                    for(int j = 0; j < Items.length; j ++)
                    {    
                        strings[j + 1] = Integer.toString((int)HowEarly("clean/log_" + (i+1) + ".csv", Items[j] ));
                        
                    }
                    csvWriter.writeNext(strings);
	        }
            csvWriter.close();
	}
        catch(Exception ee)
	{
            ee.printStackTrace();
	}
        
        //Behavior: Duration of time for each Test A 
        try
	{
            CSVWriter csvWriter = new CSVWriter(new FileWriter("DurationTimeOfTest_A.csv"));

            String[] row = new String[]{"ID", "Test#1A Time", "Test#2 Part#1A Time", "Test#2 Part#2A Time", "Test#3A Time",
                "Test#4A Time", "Test#5A Time", "Test#6A Time", "Test#7A Time"};
            csvWriter.writeNext(row); 
            
            String[] Items = new String[] {"Test #1 A", "Test #2 Part #1 A", "Test #2 Part #2 A", "Test #3 A", "Test #4 A", "Test #5 A", "Test #6 A", "Test #7 A"};
       
            String[] strings = new String[Items.length + 1];
                
                for (int i = 0; i < NumberofStudnet; i++) {
                    
                    strings[0] = Integer.toString(i+1);
                    for(int j = 0; j < Items.length; j ++)
                    {    
                        strings[j + 1] = Integer.toString((int)DurationTime("clean/log_" + (i+1) + ".csv", Items[j] ));
                        
                    }
                    csvWriter.writeNext(strings);
	        }
            csvWriter.close();
	}
        catch(Exception ee)
	{
            ee.printStackTrace();
	}
        
        
        //Behavior: Duration of time for each Test B
        try
	{
            CSVWriter csvWriter = new CSVWriter(new FileWriter("DurationTimeOfTest_B.csv"));

            String[] row = new String[]{"ID", "Test#1B Time", "Test#2 Part#1B Time", "Test#2 Part#2B Time", "Test#3B Time",
                "Test#4B Time", "Test#5B Time", "Test#6B Time", "Test#7B Time"};
            csvWriter.writeNext(row); 
            
            String[] Items = new String[] {"Test #1 B", "Test #2 Part #1 B", "Test #2 Part #2 B", "Test #3 B", "Test #4 A", "Test #5 B", "Test #6 B", "Test #7 B"};
       
            String[] strings = new String[Items.length + 1];
                
            
		for (int i = 0; i < NumberofStudnet; i++) {
                    
                    strings[0] = Integer.toString(i+1);
                    for(int j = 0; j < Items.length; j ++)
                    {    
                        strings[j + 1] = Double.toString(DurationTime("clean/log_" + (i+1) + ".csv", Items[j] ));
                        
                    }
                    csvWriter.writeNext(strings);
	        }
            csvWriter.close();
	}
        catch(Exception ee)
	{
            ee.printStackTrace();
	}
        
        //Behavior: Duration of time for each ASR 
        //Resumed... 
        try
	{
            CSVWriter csvWriter = new CSVWriter(new FileWriter("DurationTimeOfASR.csv"));

            String[] row = new String[]{"ID", "ASR#1 Time", "ASR#2A Time" , "ASR#2B Time" , "ASR#2C Time" , "ASR#3 Time" , "ASR#4 Time" ,
            "ASR#5 Time" , "ASR#6 Time", "ASR#7A Time" , "ASR#7B Time"};
            csvWriter.writeNext(row); 
            
            String[] Items = new String[] {"Submit ASR Unit #1", "Submit ASR Unit #2A", "Submit ASR Unit #2B", "Submit ASR Unit #2C" ,
            "Submit ASR Unit #3","Submit ASR Unit #4", "Submit ASR Unit #5","Submit ASR Unit #6", "Submit ASR Unit #7A" , "Submit ASR Unit #7A"};
       
            String[] strings = new String[Items.length + 1];
                
            
		for (int i = 0; i < NumberofStudnet; i++) {
                    
                    strings[0] = Integer.toString(i+1);
                    for(int j = 0; j < Items.length; j ++)
                    {    
                        strings[j + 1] = Integer.toString((int)DurationTime("clean/log_" + (i+1) + ".csv", Items[j] ));
                        
                    }
                    csvWriter.writeNext(strings);
	        }
            csvWriter.close();
	}
        catch(Exception ee)
	{
            ee.printStackTrace();
	}
        
        
      //Behavior: Duration of time for each Survey
      //Resumed... 
        try
	{
            CSVWriter csvWriter = new CSVWriter(new FileWriter("DurationTimeOfSurveys.csv"));

            String[] row = new String[]{"ID", "Mid-Term Survey Time" , "End-Term Survey Time" , "Information Survey Time"};
            csvWriter.writeNext(row); 
            
            String[] Items = new String[] {"Mid-Term Student Satisfaction Survey" , "End of Term Student Satisfaction survey" , "Student Information Survey"};
       
            String[] strings = new String[Items.length + 1];
                
            
		for (int i = 0; i < NumberofStudnet; i++) {
                    
                    strings[0] = Integer.toString(i+1);
                    for(int j = 0; j < Items.length; j ++)
                    {    
                        strings[j + 1] = Integer.toString((int)DurationTime("clean/log_" + (i+1) + ".csv", Items[j] ));
                        
                    }
                    csvWriter.writeNext(strings);
	        }
            csvWriter.close();
	}
        catch(Exception ee)
	{
            ee.printStackTrace();
	}
        
        //Behavior: Number of late ASRs submitted
        try
	{
            CSVWriter csvWriter = new CSVWriter(new FileWriter("NumberofLateARS.csv"));

            String[] row = new String[]{"ID","Number of ARSlate"};
            csvWriter.writeNext(row); 
            
            String[] strings = new String[2];
		for (int i = 0; i < NumberofStudnet; i++) {
	            strings[0] = Integer.toString(i+1);
                    strings[1] = Integer.toString(NumberofLateARS("clean/log_" + (i+1) + ".csv"));
	            
	            csvWriter.writeNext(strings);
	        }
            csvWriter.close();
	}
        catch(Exception ee)
	{
            ee.printStackTrace();
	}
    	
    }
    
    
    public static int NumberofASR(String FILE_NAME) {
        
        int numberofASR = 0;
        try {
            String strFile = FILE_NAME;
        
            CSVReader reader = new CSVReader(new FileReader(strFile));
            
            String [] nextLine;
            String value = new String();
            String value1 = new String();

            while ((nextLine = reader.readNext()) != null) {
                
                value = nextLine[4].toString();
                value1 = nextLine[6].toString();
                
                
                
                if (value.contains("Submitted") ){ 
                    if( value1.contains("ASR") && value1.contains("Submit")){
                    	numberofASR++;
                    }
                	
                }   
              
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        if(numberofASR>10) numberofASR = 10;
        return numberofASR;
    }
    
    public static int NumberofTestB(String FILE_NAME) {
        
        int numberofTest = 0;
        try {
            String strFile = FILE_NAME;
        
            CSVReader reader = new CSVReader(new FileReader(strFile));
            
            String [] nextLine;
            String value = new String();
            String value1 = new String();

            while ((nextLine = reader.readNext()) != null) {
                
                value = nextLine[4].toString();
                value1 = nextLine[6].toString();
                
                if (value.contains("Submitted") ){ 
                    if( value1.contains("Test") && value1.contains("B")){
                        numberofTest++;
                    }
                	
                }   
              
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return numberofTest;
    }
    
    
    public static long DurationTime(String FILE_NAME, String Item) {
        
        long duration = 0;
        try {
            String strFile = FILE_NAME;
        
            CSVReader reader = new CSVReader(new FileReader(strFile));
            
            String [] nextLine;
            String value = new String();
            String value1 = new String();
            boolean isStarted = false;
            
            Date StartTimeForTest = null;
            Date EndTimeFortest = null;

            while ((nextLine = reader.readNext()) != null) {
                
            	String subdate ="", prevdate = "";
                value = nextLine[6].toString();
                value1 = nextLine[4].toString();
                int flag = 0;
                if (value.contains(Item) && value1.contains("Delivered") && !isStarted){ 
                    try { 
                        
                        prevdate = nextLine[2].toString();
                        StartTimeForTest = new SimpleDateFormat("hh:mm:ss a").parse(nextLine[3].toString());
                       
                       
                        
                    } catch (ParseException ex) {
                       
                    }
                    isStarted = true;
                }   
                
                if(isStarted && value.contains(Item) && value1.contains("Submitted")){
                    try {

                        subdate = nextLine[2].toString();
                        
                        EndTimeFortest = new SimpleDateFormat("hh:mm:ss a").parse(nextLine[3].toString());
                    } catch (ParseException ex) {
                        
                    }
                     
                    Calendar calendar = GregorianCalendar.getInstance();
                    calendar.setTime(EndTimeFortest);
                    calendar.setTime(StartTimeForTest);
                 
                    duration = EndTimeFortest.getTime() / 60000 - StartTimeForTest.getTime() / 60000;
                    
                    
                    if (duration<0) {
                    	   calendar.setTime(EndTimeFortest);
                    	   calendar.add(Calendar.DATE, 1);
                           EndTimeFortest = calendar.getTime();
                           duration = EndTimeFortest.getTime() / 60000 - StartTimeForTest.getTime() / 60000;
                    	
                    }
                    
                   
                    return TimeUnit.MINUTES.toMinutes(duration);
                    //return duration;
                    
                }
              
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return duration;
    }
    
    public static long HowEarly(String FILE_NAME, String Item) {
        
        long duration = 0;
        try {
            String strFile = FILE_NAME;
        
            CSVReader reader = new CSVReader(new FileReader(strFile));
            
            String [] nextLine;
            String value = new String();
            String value1 = new String();
            
            Date StartTimeForTest = null;
            

            while ((nextLine = reader.readNext()) != null) {
                
                value = nextLine[6].toString();
                value1 = nextLine[4].toString();
                try {
                    Date d1 = new SimpleDateFormat("MM/dd/yyyy").parse("1/25/13");
                    
                    

                if (value1.contains("Submitted")){ 
                	
                			if(Item.equals("Test #1 A")){
                				if(!value.contains(Item)) continue;
                        StartTimeForTest = new SimpleDateFormat("MM/dd/yyyy").parse(nextLine[0].toString());
                        
                    } 
                    if(Item.equals("Test #2 Part #1 A")){
                    	if(!value.contains(Item)) continue;
                        d1 = new SimpleDateFormat("MM/dd/yyyy").parse("2/1/13");
                        StartTimeForTest = new SimpleDateFormat("MM/dd/yyyy").parse(nextLine[0].toString());
                        
                       
                    } 
                    if(Item.equals("Test #2 Part #2 A")){
                    	if(!value.contains(Item)) continue;
                        d1 = new SimpleDateFormat("MM/dd/yyyy").parse("2/8/13");
                        StartTimeForTest = new SimpleDateFormat("MM/dd/yyyy").parse(nextLine[0].toString());
                        
                        
                    } 
                    if(Item.equals("Test #3 A")){
                    	if(!value.contains(Item)) continue;
                        d1 = new SimpleDateFormat("MM/dd/yyyy").parse("2/15/13");
                        StartTimeForTest = new SimpleDateFormat("MM/dd/yyyy").parse(nextLine[0].toString());
                        
                       
                    } 
                    if(Item.equals("Test #4 A")){
                    	if(!value.contains(Item)) continue;
                        d1 = new SimpleDateFormat("MM/dd/yyyy").parse("3/1/13");
                        StartTimeForTest = new SimpleDateFormat("MM/dd/yyyy").parse(nextLine[0].toString());
                       
                       
                    } 
                    if(Item.equals("Test #5 A")){
                    	if(!value.contains(Item)) continue;
                        d1 = new SimpleDateFormat("MM/dd/yyyy").parse("3/8/13");
                        StartTimeForTest = new SimpleDateFormat("MM/dd/yyyy").parse(nextLine[0].toString());
                       
                    }
                    if(Item.equals("Test #6 A")){
                    	if(!value.contains(Item)) continue;
                        d1 = new SimpleDateFormat("MM/dd/yyyy").parse("3/15/13");
                        StartTimeForTest = new SimpleDateFormat("MM/dd/yyyy").parse(nextLine[0].toString());
                        
                        
                    } 
                    if(Item.equals("Test #7 A")){
                    	if(!value.contains(Item)) continue;
                        d1 = new SimpleDateFormat("MM/dd/yyyy").parse("3/22/13");
                        StartTimeForTest = new SimpleDateFormat("MM/dd/yyyy").parse(nextLine[0].toString());
                        
                       
                    } 
                    duration = d1.getTime() /(60000 * 24 * 60) - StartTimeForTest.getTime() / (60000 * 24  * 60);
                    if(duration < 0)
                        duration = duration * -1;
                    return TimeUnit.DAYS.toDays(duration);
                }
                
                
                
                } catch (ParseException ex) {
                    Logger.getLogger(Behaviors.class.getName()).log(Level.SEVERE, null, ex);
                }
              
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return duration;
    }
    
    public static int NumberofAssignment(String FILE_NAME) {
        
        int numberofAssignments = 0;
        try {
            String strFile = FILE_NAME;
        
            CSVReader reader = new CSVReader(new FileReader(strFile));
            
            String [] nextLine;
            String value = new String();
            String value1 = new String();

            while ((nextLine = reader.readNext()) != null) {
                
                value = nextLine[6].toString();
                value1 = nextLine[4].toString();
                
                if (value.contains("Optional CyberRat Assignment") && value1.contains("Submitted")){ 
                	numberofAssignments++;
                }   
              
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return numberofAssignments;
    }
    
            
    public static int NumberofLateARS(String FILE_NAME) {
        
        int numberofTest = 0;
        try {
            String strFile = FILE_NAME;
        
            CSVReader reader = new CSVReader(new FileReader(strFile));
            
            String [] nextLine;
            String value = new String();
            String value1 = new String();
            String date_str = new String();

            while ((nextLine = reader.readNext()) != null) {
                
                value = nextLine[4].toString();
                value1 = nextLine[6].toString();
                date_str = nextLine[0].toString();
                
                Date date;
                try {
                    date = new SimpleDateFormat("MM/dd/yyyy").parse(date_str);
                
               
                if (value.contains("Submitted") && value1.contains("Submit") && value1.contains("ASR Unit")){
                    Date d1 = new SimpleDateFormat("MM/dd/yyyy").parse("1/29/13");
                    if(value1.contains("#1")){
                        if(d1.before(date))
                            numberofTest++;
                    }
                    
                    d1 = new SimpleDateFormat("MM/dd/yyyy").parse("2/5/13");
                    if(value1.contains("#2A")){
                        if(d1.before(date))
                            numberofTest++;
                    }
                    
                    d1 = new SimpleDateFormat("MM/dd/yyyy").parse("2/5/13");
                    
                    if(value1.contains("#2B")){
                        if(d1.before(date))
                            numberofTest++;
                    }
                    
                    d1 = new SimpleDateFormat("MM/dd/yyyy").parse("2/12/13");
                    if(value1.contains("#3")){
                        if(d1.before(date))
                            numberofTest++;
                    }
                    
                    d1 = new SimpleDateFormat("MM/dd/yyyy").parse("2/19/13");
                    if(value1.contains("#2C")){
                        if(d1.before(date))
                            numberofTest++;
                    }
                    
                    d1 = new SimpleDateFormat("MM/dd/yyyy").parse("3/5/13");
                    if(value1.contains("#4")){
                        if(d1.before(date))
                            numberofTest++;
                    }
                    
                    
                    d1 = new SimpleDateFormat("MM/dd/yyyy").parse("3/12/13");
                    if(value1.contains("#5")){
                        if(d1.before(date))
                            numberofTest++;
                    }
                    
                    d1 = new SimpleDateFormat("MM/dd/yyyy").parse("3/19/13");
                    if(value1.contains("#6")){
                        if(d1.before(date))
                            numberofTest++;
                    }
                    
                    
                    d1 = new SimpleDateFormat("MM/dd/yyyy").parse("3/26/13");
                    if(value1.contains("#7A")){
                        if(d1.before(date))
                            numberofTest++;
                    }
                    
                    d1 = new SimpleDateFormat("MM/dd/yyyy").parse("3/26/13");
                    if(value1.contains("#7B")){
                        if(d1.before(date))
                            numberofTest++;
                    }
                    
                }
                   
                } catch (ParseException ex) {
                    
                }
            }
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return numberofTest;
    }
  
    
    
}
