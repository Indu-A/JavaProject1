/**
 * File: RecipientsBusinessLogic.java
 * Author: Indupoornima Aruvythil
 * Student Number: 041037831
 * Course & Section: 22S_CST8288_012
 * Description: Demonstration of DAO Design Pattern, MVC Design Pattern
 * Reference: Stanley Pieda AuthorsBusinessLogic.java (2015)
 */
package businesslayer;

import java.util.List;
import dataaccesslayer.RecipientsDaoImpl;
import transferobjects.RecipientDTO;
import dataaccesslayer.RecipientsDao;
import java.sql.ResultSetMetaData;

public class RecipientsBusinessLogic {
	private static final int NAME_MAX_LENGTH = 60;
	
	private RecipientsDao recipientsDao = null;
	
	public RecipientsBusinessLogic(){
		recipientsDao = new RecipientsDaoImpl();
	}
	
	public List<RecipientDTO> getAllRecipients(){
		return recipientsDao.getAllRecipients();
	}
	
	public RecipientDTO getRecipient(Integer awardID){
		return recipientsDao.getRecipientByAwardId(awardID);
	}
	
	public void addRecipient(RecipientDTO recipient) throws ValidationException{
		cleanRecipient(recipient);
		validateRecipient(recipient);
		recipientsDao.addRecipient(recipient);
	}
	
	public void updateRecipient(RecipientDTO recipient) throws ValidationException{
		cleanRecipient(recipient);
		validateRecipient(recipient);
		recipientsDao.updateRecipient(recipient);
	}
	
	public void deleteRecipient(RecipientDTO recipient){
		recipientsDao.deleteRecipient(recipient);
	}
	
	public ResultSetMetaData ResultSet_getMetaData(){
		return recipientsDao.ResultSet_getMetaData();
	}
	
	private void cleanRecipient(RecipientDTO recipient){
		if(recipient.getName() != null){ 
			recipient.setName(recipient.getName().trim());
		}
	}
	
	private void validateRecipient(RecipientDTO recipient) throws ValidationException{
		validateString(recipient.getName(), "Name", NAME_MAX_LENGTH, true);
	}
	
	private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed)
	    throws ValidationException{
		if(value == null && isNullAllowed){
			// return; // null permitted, nothing to validate
		}
		else if(value == null && ! isNullAllowed){
		    throw new ValidationException(String.format("%s cannot be null", 
		    		fieldName));
		}
		else if(value.length() == 0){
			throw new ValidationException(String.format("%s cannot be empty or only whitespace", 
					fieldName));
		}
		else if(value.length() > maxLength){
			throw new ValidationException(String.format("%s cannot exceed %d characters", 
					fieldName, maxLength));
		}
	}
	/*
	private void validateInt(int value, String fieldName)
	    throws ValidationException{
		if(value <= 0){
			throw new ValidationException(String.format("%s cannot be a negative number", 
					fieldName));
		}
	}
	*/
}
