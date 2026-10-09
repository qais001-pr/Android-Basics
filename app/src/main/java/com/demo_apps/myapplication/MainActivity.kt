// For Notification Activity

//package com.demo_apps.myapplication
//import android.content.Intent
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//class MainActivity : ComponentActivity() {
////
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState);
//    //    For Notification Activity
//            val intent = Intent(this@MainActivity, notification::class.java)
//            startActivity(intent)
//    }
//}


// For Fragment Activities
//
//package com.demo_apps.myapplication
//
//import android.os.Bundle
//import androidx.fragment.app.FragmentActivity
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.commit
//
//class MainActivity : FragmentActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        setContentView(R.layout.activity_main)
//
//        // Display Fragment when Activity starts
//            supportFragmentManager.commit {
//                add(R.id.fragmentContainer, HomeFragment())
//                add(R.id.fragmentContainer1, ProfileFragment())
//        }
//    }
//}

// For Picker View

//package com.demo_apps.myapplication
//
//import android.os.Bundle
//import android.widget.Button
//import android.widget.DatePicker
//import android.widget.NumberPicker
//import android.widget.TextView
//import android.widget.TimePicker
//import androidx.activity.ComponentActivity
//
//
//class MainActivity : ComponentActivity() {
//    var datePicker: DatePicker? = null
//    var timePicker: TimePicker? = null
//    var numberPicker: NumberPicker? = null
//    var btnSubmit: Button? = null
//    var txtResult: TextView? = null
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        setContentView(R.layout.picker_view);
//        datePicker = findViewById<DatePicker>(R.id.datePicker);
//        timePicker = findViewById<TimePicker>(R.id.timePicker);
//        numberPicker = findViewById<NumberPicker>(R.id.numberPicker);
//        btnSubmit = findViewById<Button>(R.id.btnSubmit);
//        txtResult = findViewById<TextView>(R.id.txtResult);
//
//        numberPicker?.minValue =1;
//        numberPicker?.maxValue = 10;
//        numberPicker?.value = 1;
//
//
//        btnSubmit?.setOnClickListener {
//
//            val day = datePicker?.dayOfMonth
//            val month = datePicker?.month?.plus(1)
//            val year = datePicker?.year
//
//            val hour = timePicker?.hour
//            val minute = timePicker?.minute
//
//            val quantity = numberPicker?.value
//
//            val result = String.format(
//                java.util.Locale.getDefault(),
//                "Selected Date: %02d/%02d/%04d\n" +
//                        "Selected Time: %02d:%02d\n" +
//                        "Selected Quantity: %d",
//                day, month, year,
//                hour, minute,
//                quantity
//            )
//
//            txtResult?.text = result
//        }
//    }
//}
//


// Radio Button

//package com.demo_apps.myapplication

//import android.content.pm.ActivityInfo
//import android.os.Bundle
//import android.widget.ArrayAdapter
//import android.widget.Button
//import android.widget.ListView
//import android.widget.TextView
//import android.widget.Toast
//import androidx.activity.ComponentActivity

//class MainActivity : ComponentActivity() {

//    var btnPortrait: Button?=null;
//    var landscape: Button?=null;
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//     For Screen Orientation
//        setContentView(R.layout.list_view)
//        btnPortrait = findViewById<Button>(R.id.btnPortrait);
//        landscape = findViewById<Button>(R.id.btnLandscape);
//        btnPortrait?.setOnClickListener {
//            requestedOrientation=ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED;
//        }
//        landscape?.setOnClickListener {
//            requestedOrientation= ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
//        }

//
//
//        val listView = findViewById<ListView>(R.id.listView)
//        val txtResult = findViewById<TextView>(R.id.txtResult)
//
//        // List of students
//        val students = arrayOf(
//            "Ali",
//            "Ahmed",
//            "Usman",
//            "Hassan",
//            "Bilal",
//            "Hamza",
//            "Zain"
//        )
//
//        // Connect data with ListView
//        val adapter = ArrayAdapter(
//            this,
//            android.R.layout.simple_list_item_1,
//            students
//        )
//
//        listView.adapter = adapter
//        listView.setOnItemClickListener { _, _, position, _ ->
//
//            val selectedStudent = students[position]
//
//            txtResult.text = "Selected Student: $selectedStudent"
//
//            Toast.makeText(
//                this,
//                "You selected $selectedStudent",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//    }
//}


// Check Box

//package com.demo_apps.myapplication
//
//import android.os.Bundle
//import android.widget.Button
//import android.widget.CheckBox
//import android.widget.TextView
//import androidx.activity.ComponentActivity
//
//class MainActivity : ComponentActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.check_box)
//
//        val checkJava = findViewById<CheckBox>(R.id.checkJava)
//        val checkKotlin = findViewById<CheckBox>(R.id.checkKotlin)
//        val checkPython = findViewById<CheckBox>(R.id.checkPython)
//        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
//        val txtResult = findViewById<TextView>(R.id.txtResult)
//
//        btnSubmit.setOnClickListener {
//
//            val selected = mutableListOf<String>()
//
//            if (checkJava.isChecked) selected.add("Java")
//            if (checkKotlin.isChecked) selected.add("Kotlin")
//            if (checkPython.isChecked) selected.add("Python")
//
//            txtResult.text = if (selected.isEmpty()) {
//                "No language selected"
//            } else {
//                "Selected: ${selected.joinToString(", ")}"
//            }
//        }
//    }
//}



// For User Input


//package com.demo_apps.myapplication
//
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.RadioGroup
//import android.widget.TextView
//import android.widget.Toast
//import androidx.activity.ComponentActivity
//
//class MainActivity : ComponentActivity() {
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.input)
//        val edtName = findViewById<EditText>(R.id.edtName)
//        val btnGreet = findViewById<Button>(R.id.btnGreet)
//        val txtGreeting = findViewById<TextView>(R.id.txtGreeting)
//
//        btnGreet.setOnClickListener {
//            val name = edtName.text.toString().trim()
//
//            if (name.isEmpty()) {
//                edtName.error = "Enter your name"
//            } else {
//                txtGreeting.text = "Hello, $name!"
//            }
//        }
//        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup)
//        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
//        val txtResult = findViewById<TextView>(R.id.txtResult)
//
//        btnSubmit.setOnClickListener {
//
//            val selectedId = radioGroup.checkedRadioButtonId
//
//            if (selectedId == -1) {
//                Toast.makeText(
//                    this,
//                    "Please select an option",
//                    Toast.LENGTH_SHORT
//                ).show()
//            } else {
//                val selectedRadio =
//                    findViewById<android.widget.RadioButton>(selectedId)
//
//                txtResult.text = "Selected: ${selectedRadio.text}"
//            }
//        }
//    }



// For Image Viewer
//
//package com.demo_apps.myapplication
//import android.net.Uri
//import android.os.Bundle
//import android.widget.Button
//import android.widget.ImageView
//import androidx.activity.ComponentActivity
//import androidx.activity.result.contract.ActivityResultContracts
//
//class MainActivity : ComponentActivity() {
//
//    private lateinit var imageView: ImageView
//
//    private val imagePicker = registerForActivityResult(
//        ActivityResultContracts.GetContent()
//    ) { uri: Uri? ->
//
//        if (uri != null) {
//            imageView.setImageURI(uri)
//        }
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.image_picker)
//
//        imageView = findViewById(R.id.imageView)
//
//        val btnPickImage =
//            findViewById<Button>(R.id.btnPickImage)
//
//        btnPickImage.setOnClickListener {
//            imagePicker.launch("image/*")
//        }
//    }
//}



// Clock View
//
//package com.demo_apps.myapplication
//import android.os.Bundle
//import androidx.activity.ComponentActivity
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.clocks)
//    }
//}



// For Persistent Storage
//
//package com.demo_apps.myapplication
//
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
//import android.widget.Toast
//import androidx.activity.ComponentActivity
//import java.io.FileNotFoundException
//import java.io.IOException
//
//class MainActivity : ComponentActivity() {
//
//    private val fileName = "student_data.txt"
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.persistent_file)
//
//        val editTextData = findViewById<EditText>(R.id.editTextData)
//        val btnSave = findViewById<Button>(R.id.btnSave)
//        val btnRead = findViewById<Button>(R.id.btnRead)
//        val textViewResult = findViewById<TextView>(R.id.textViewResult)
//
//        // Save data to the internal file
//        btnSave.setOnClickListener {
//            val data = editTextData.text.toString()
//
//            try {
//                openFileOutput(fileName, MODE_PRIVATE).use { output ->
//                    output.write(data.toByteArray(Charsets.UTF_8))
//                }
//
//                Toast.makeText(
//                    this,
//                    "Data saved successfully",
//                    Toast.LENGTH_SHORT
//                ).show()
//
//            } catch (e: IOException) {
//                Toast.makeText(
//                    this,
//                    "Error saving data",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        }
//
//        // Read data from the internal file
//        btnRead.setOnClickListener {
//            try {
//                val data = openFileInput(fileName)
//                    .bufferedReader(Charsets.UTF_8)
//                    .use { it.readText() }
//
//                textViewResult.text = data
//
//            } catch (e: FileNotFoundException) {
//                textViewResult.text = "No saved file found"
//
//            } catch (e: IOException) {
//                textViewResult.text = "Error reading file"
//            }
//        }
//    }
//}
//
//
//
//package com.demo_apps.myapplication
//
//import android.os.Bundle
//import android.widget.Button
//import android.widget.EditText
//import android.widget.TextView
//import android.widget.Toast
//import androidx.activity.ComponentActivity
//
//class MainActivity : ComponentActivity() {
//
//    private lateinit var dbHelper: DatabaseHelper
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.db_storage)
//
//        dbHelper = DatabaseHelper(this)
//
//        val edtName = findViewById<EditText>(R.id.edtName)
//        val edtAge = findViewById<EditText>(R.id.edtAge)
//        val btnInsert = findViewById<Button>(R.id.btnInsert)
//        val btnView = findViewById<Button>(R.id.btnView)
//        val btnDelete = findViewById<Button>(R.id.btnDelete)
//        val txtResult = findViewById<TextView>(R.id.txtResult)
//
//        // Insert a student
//        btnInsert.setOnClickListener {
//            val name = edtName.text.toString().trim()
//            val ageText = edtAge.text.toString().trim()
//
//            if (name.isEmpty() || ageText.isEmpty()) {
//                Toast.makeText(
//                    this,
//                    "Please enter name and age",
//                    Toast.LENGTH_SHORT
//                ).show()
//                return@setOnClickListener
//            }
//
//            val age = ageText.toIntOrNull()
//
//            if (age == null || age <= 0) {
//                Toast.makeText(
//                    this,
//                    "Enter a valid age",
//                    Toast.LENGTH_SHORT
//                ).show()
//                return@setOnClickListener
//            }
//
//            val inserted = dbHelper.insertStudent(name, age)
//
//            if (inserted) {
//                Toast.makeText(
//                    this,
//                    "Student inserted successfully",
//                    Toast.LENGTH_SHORT
//                ).show()
//
//                edtName.text.clear()
//                edtAge.text.clear()
//            } else {
//                Toast.makeText(
//                    this,
//                    "Failed to insert student",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        }
//
//        // Display all students
//        btnView.setOnClickListener {
//            txtResult.text = dbHelper.getAllStudents()
//        }
//
//        // Delete all students
//        btnDelete.setOnClickListener {
//            val deletedCount = dbHelper.deleteAllStudents()
//
//            txtResult.text = "Deleted records: $deletedCount"
//
//            Toast.makeText(
//                this,
//                "$deletedCount student record(s) deleted",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//    }
//
//    override fun onDestroy() {
//        dbHelper.close()
//        super.onDestroy()
//    }
//}



// Content Provider


package com.demo_apps.myapplication

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat

class MainActivity : ComponentActivity() {

    private lateinit var txtContacts: TextView

    private val permissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { granted ->
            if (granted) {
                loadContacts()
            } else {
                txtContacts.text =
                    "Contact permission was not granted."
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.contant_main)

        val btnLoadContacts =
            findViewById<Button>(R.id.btnLoadContacts)

        txtContacts = findViewById(R.id.txtContacts)

        btnLoadContacts.setOnClickListener {
            checkPermissionAndLoad()
        }
    }

    private fun checkPermissionAndLoad() {
        val permission = Manifest.permission.READ_CONTACTS

        if (ContextCompat.checkSelfPermission(
                this,
                permission
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            loadContacts()
        } else {
            permissionLauncher.launch(permission)
        }
    }

    private fun loadContacts() {
        val result = StringBuilder()

        val uri = ContactsContract.CommonDataKinds.Phone.CONTENT_URI

        val projection = arrayOf(
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
            ContactsContract.CommonDataKinds.Phone.NUMBER
        )

        try {
            contentResolver.query(
                uri,
                projection,
                null,
                null,
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                        + " ASC"
            )?.use { cursor ->

                val nameIndex = cursor.getColumnIndexOrThrow(
                    ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
                )

                val numberIndex = cursor.getColumnIndexOrThrow(
                    ContactsContract.CommonDataKinds.Phone.NUMBER
                )

                while (cursor.moveToNext()) {
                    val name = cursor.getString(nameIndex)
                    val number = cursor.getString(numberIndex)

                    result.append("Name: $name\n")
                    result.append("Phone: $number\n\n")
                }
            }

            txtContacts.text = if (result.isEmpty()) {
                "No contacts found."
            } else {
                result.toString()
            }

        } catch (e: SecurityException) {
            Toast.makeText(
                this,
                "Contact permission is required.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}