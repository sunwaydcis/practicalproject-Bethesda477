package ch.makery.address

import ch.makery.address.model.Person
import javafx.fxml.FXMLLoader
import scalafx.application.JFXApp3
import scalafx.application.JFXApp3.PrimaryStage
import scalafx.scene.Scene
import scalafx.Includes.*
import javafx.scene as jfxs
import scalafx.beans.property.StringProperty
import scalafx.collections.ObservableBuffer

object MainApp extends JFXApp3:

  // Window Root Pane
  var roots: Option[scalafx.scene.layout.BorderPane] = None
  // ... AFTER THE OTHER VARIABLES ...
  // The data as an observable list of Persons.
  val personData = new ObservableBuffer[Person]()
  // Constructor
  personData += new Person("Hans", "Muster")
  personData += new Person("Ruth", "Mueller")
  personData += new Person("Heinz", "Kurz")
  personData += new Person("Cornelia", "Meier")
  personData += new Person("Werner", "Meyer")
  personData += new Person("Lydia", "Kunz")
  personData += new Person("Anna", "Best")
  personData += new Person("Stefan", "Meier")
  personData += new Person("Martin", "Mueller")

  //if add a collection to a collection ++
  //if adding a value to a collection +=

  override def start(): Unit =
    // transform path of RootLayout.fxml to URI for resource location.
    val rootResource = getClass.getResource("view/RootLayout.fxml") //Relative address
    //absolute address: /ch/makery/address/view/.

    // initialize the loader object.
    val loader = new FXMLLoader(rootResource)
    // Load root layout from fxml file.
    loader.load()

    // retrieve the root component BorderPane from the FXML
    roots = Option(loader.getRoot[jfxs.layout.BorderPane])   //get most outtest element, because outtest elemnt contain everything

    stage = new PrimaryStage():
      title = "AddressApp"
      scene = new Scene():
        root = roots.get

    // call to display PersonOverview when app start
    showPersonOverview()
  // actions for display person overview window
  def showPersonOverview(): Unit =
    val resource = getClass.getResource("view/PersonOverview.fxml")
    val loader = new FXMLLoader(resource)
    loader.load()
    val roots = loader.getRoot[jfxs.layout.AnchorPane]
    this.roots.get.center = roots //auto conversion from Javafx to scalafx

  //StringProperty
  // ObjectProperty for all other than string: int, double
  //StringProperty is not a value, to call value use .value

  val aString = new StringProperty("Sunway") //publisher
  val bString = new StringProperty("Monash") //subscriber

  bString <==> aString   //b subscribe to a, any updates from a will reflect on a
  aString.onChange((a, b, c) => {
    println("aString changed from" + b + "to" + c)
  }
  )
//  bString.value = "ddd"  //error: A bound value cannot be set. b is bounded, only after unbound can set
//  println(aString.value)
//  println(bString.value)


  /////////////////////////////////////////////////
//  val add: (Int, Int) => Int = (_,_) => //this is an anonymous function: (parameter) => {body} or indentation; then assign it to a val
//    a + b  //                      this two Int is neglecteble because mentioned infront
//  println(add)

    // xxxx=>xxxx is a function type
    //def onChange[J1 >: J](op: (ObservableValue[T, J], J1, J1) => Unit): Subscription
    //     func_Name        1stPara_name: para_type


    //StringProperty can bind to other String property
    // a function parameter can contain >1 StringProperty


    //one FXML one controller only