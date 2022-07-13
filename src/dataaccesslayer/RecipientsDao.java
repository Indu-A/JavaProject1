/**
 * File: RecipientDataAccessObject.java
 * Student Name: Indupoornima Aruvythil
 * Student Number: 041037831
 * Course & Section: 22S_CST8288_012
 * Description: Demonstration of DAO Design Pattern, MVC Design Pattern
 * Reference: Stanley Pieda AuthorsDataAccessObject.java (2015)
 */
package dataaccesslayer;

import java.sql.ResultSetMetaData;
import java.util.List;

import transferobjects.RecipientDTO;

public interface RecipientsDao {
	List<RecipientDTO> getAllRecipients();
	RecipientDTO getRecipientByAwardId(Integer awardID);
	void addRecipient(RecipientDTO recipient);
	void updateRecipient(RecipientDTO recipient);
	void deleteRecipient(RecipientDTO recipient);
	ResultSetMetaData ResultSet_getMetaData();
}
