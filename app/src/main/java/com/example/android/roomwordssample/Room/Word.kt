package com.example.android.roomwordssample.Room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * kelas dasar yang mewakili entitas yang merupakan baris dalam tabel database satu kolom.
 */

@Entity(tableName = "word_table")
data class Word(@PrimaryKey @ColumnInfo(name = "word") val word: String)
