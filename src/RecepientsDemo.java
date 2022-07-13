/**
 * File: RecepientsDemo.java
 * Student Name: Indupoornima Aruvythil
 * Student Number: 041037831
 * Course & Section: 22S_CST8288_012
 * Reference: Stanley Pieda AuthorsDemo.java (2015)
 */
import businesslayer.RecipientsBusinessLogic;
import businesslayer.ValidationException;
import transferobjects.RecipientDTO;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.List;
public class RecepientsDemo {

	public void demo(){
            try{
                RecipientsBusinessLogic logic = new RecipientsBusinessLogic();
                List<RecipientDTO> list = null;
                RecipientDTO recipient = null;
                System.out.println("Printing Recipients");
                list = logic.getAllRecipients();
                printRecipients(list);
                System.out.println("Printing One Recipient");
                recipient = logic.getRecipient(1);
                printRecipient(recipient);
                System.out.println();

                System.out.println("Inserting One Recipient");
                recipient = new RecipientDTO();
                recipient.setName("FirstTestAdd");
                recipient.setYear(1234);
                recipient.setCity("CityTestAdd");
                recipient.setCategory("CategoryTestAdd");
                logic.addRecipient(recipient);
                list = logic.getAllRecipients();
                printRecipients(list);

//                System.out.println("Updating last recipient");
//                Integer updatePrimaryKey = list.get(list.size() - 1).getAwardID();
//                recipient = new RecipientDTO();
//                recipient.setAwardID(updatePrimaryKey);
//                recipient.setName("FirstTestUpdate");
//                recipient.setYear(1233);
//                recipient.setCity("CityTestUpdate");
//                recipient.setCategory("CategoryTestUpdate");
//                logic.updateRecipient(recipient);
//                list = logic.getAllRecipients();
//                printRecipients(list);
//
//                System.out.println("Deleting last recipient");
//                recipient = list.get(list.size() - 1);
//                logic.deleteRecipient(recipient);
//                list = logic.getAllRecipients();
//                printRecipients(list);
                
                System.out.println("Printing ResultSetMetadata:");
                ResultSetMetaData resultSetMetadata = null;
                resultSetMetadata = logic.ResultSet_getMetaData();
                printAttributes(resultSetMetadata);
            }
            catch(ValidationException e){
                    System.err.println(e.getMessage());                        
            }
                 
        }
        
	private static void printRecipient(RecipientDTO recipient){
	    	String output = String.format("%s, %s, %s, %s, %s",
	    			recipient.getAwardID().toString(),
	    			recipient.getName(),
	    			recipient.getYear().toString(),
	    			recipient.getCity(),
                                recipient.getCategory());
	    	System.out.println(output);
	}
	
	private static void printRecipients(List<RecipientDTO> recipients){
	    for(RecipientDTO recipient : recipients){
	    	printRecipient(recipient);
	    }
	    System.out.println();
	}
        
	private static void printAttributes(ResultSetMetaData resultSetMetadata){
            try{
                for (int i=1; i<=resultSetMetadata.getColumnCount(); i++){
                    String columnName = resultSetMetadata.getColumnName(i);
                    String columnType = resultSetMetadata.getColumnTypeName(i);
                    String columnClass = resultSetMetadata.getColumnClassName(i);
                    System.out.println("Column name: "+ columnName);
                    System.out.println("Column type: "+ columnType);
                    System.out.println("Column type: "+ columnClass);
                    System.out.println();
                }
            }            
            catch(SQLException e){
                    e.printStackTrace();
            }
        }

}
