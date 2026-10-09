
package com.demo_apps.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, "StudentDB", null, 1) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL(
            """
            CREATE TABLE students (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                name TEXT NOT NULL,
                age INTEGER NOT NULL
            )
            """.trimIndent()
        )
    }

    override fun onUpgrade(
        db: SQLiteDatabase,
        oldVersion: Int,
        newVersion: Int
    ) {
        db.execSQL("DROP TABLE IF EXISTS students")
        onCreate(db)
    }

    fun insertStudent(name: String, age: Int): Boolean {
        val db = writableDatabase

        val values = ContentValues().apply {
            put("name", name)
            put("age", age)
        }

        val result = db.insert("students", null, values)
        return result != -1L
    }

    fun getAllStudents(): String {
        val db = readableDatabase
        val result = StringBuilder()

        val cursor = db.rawQuery(
            "SELECT id, name, age FROM students ORDER BY id",
            null
        )

        cursor.use {
            while (it.moveToNext()) {
                val id = it.getInt(0)
                val name = it.getString(1)
                val age = it.getInt(2)

                result.append(
                    "ID: $id | Name: $name | Age: $age\n\n"
                )
            }
        }

        return if (result.isEmpty()) {
            "No student records found."
        } else {
            result.toString()
        }
    }

    fun deleteAllStudents(): Int {
        val db = writableDatabase
        return db.delete("students", null, null)
    }
}