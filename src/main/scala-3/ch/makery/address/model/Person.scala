package ch.makery.address.model
import scalafx.beans.property.{StringProperty, IntegerProperty,
  ObjectProperty}
import java.time.LocalDate
class Person ( firstNameS : String, lastNameS : String ):
  var firstName = new StringProperty(firstNameS)
  var lastName = new StringProperty(lastNameS)
  var street = new StringProperty("some Street")// var postalCode = IntegerProperty(1234)
  var postalCode = ObjectProperty[Int](1234)
  var city = new StringProperty("some city")
  var date = ObjectProperty[LocalDate](LocalDate.of(1999, 2, 21)) //LocalDate is from Javafx class, I convert to scalafx

//no 'New' , we dont call constructor, we call companion object ; because ObjectProperty API constructor need bean
