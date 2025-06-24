package ch.makery.address.view
import ch.makery.address.model.Person
import ch.makery.address.MainApp
import javafx.fxml.FXML
import javafx.scene.control.{Label, TableColumn, TableView, TextField}
import scalafx.Includes.*
@FXML
class PersonOverviewController():
  @FXML
  private var personTable: TableView[Person] = null
  @FXML
  private var firstNameColumn: TableColumn[Person, String] = null
  @FXML
  private var lastNameColumn: TableColumn[Person, String] = null
  @FXML
  private var firstNameLabel: Label = null
  @FXML
  private var lastNameLabel: Label = null
  @FXML
  private var streetLabel: Label = null
  @FXML
  private var postalCodeLabel: Label = null
  @FXML
  private var cityLabel: Label = null
  @FXML
  private var birthdayLabel: Label = null
  @FXML
  private var mytext: TextField = null
  //put in javafx not scalafx here because fxml run javafax

  // initialize Table View display contents model
  def initialize() =
    personTable.items = MainApp.personData
    // initialize columns's cell values
    firstNameColumn.cellValueFactory = {x => x.value.firstName}  //LONG FORM
    lastNameColumn.cellValueFactory = {_.value.lastName}  //SHORT FORM
    //   _ = x => x  = any

    //publisher
    firstNameLabel.text <== mytext.text

//HOW to make a couple of simultaneous textfield
    //step1: put a idname
    //step2: create private var idname : xxx = null
    //step3: publisher.text <== idname.text