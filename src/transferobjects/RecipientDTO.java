/**
 * File: RecipientDTO.java
 * Author: Indupoornima Aruvythil
 * Student Number: 041037831
 * Course & Section: 22S_CST8288_012
 * Description: Demonstration of DAO Design Pattern, MVC Design Pattern
 * Reference: Stanley Pieda AuthorsDTO.java (2015)
 */
package transferobjects;
/**
 * this is the transfer object which is having all the getters and setters of the table attributes.
 * @author indup
 */
public class RecipientDTO {
    private Integer awardID;
    private String name;
    private Integer year;
    private String city;
    private String category;
    
    public Integer getAwardID(){
    	return awardID;
    }
    public void setAwardID(Integer awardID){
    	this.awardID = awardID;
    }
    
    public String getName(){
    	return name;
    }
    public void setName(String name){
    	this.name = name;
    }
    
    public Integer getYear(){
    	return year;
    }
    public void setYear(Integer year){
    	this.year = year;
    }
    
    public String getCity(){
    	return city;
    }
    public void setCity(String city){
    	this.city = city;
    }
    
    public String getCategory(){
    	return category;
    }
    public void setCategory(String category){
    	this.category = category;
    }
    
}
