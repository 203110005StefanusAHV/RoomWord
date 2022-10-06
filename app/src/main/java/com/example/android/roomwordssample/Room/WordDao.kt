package com.example.android.roomwordssample.Room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.android.roomwordssample.Room.Word

/**
 * Room Magic ada di file ini, tempat untuk memetakan panggilan metode Java ke kueri SQL.
 */

@Dao
interface WordDao {

    // LiveData adalah kelas pemegang data yang dapat diamati dalam lifecycle.
    // Selalu menyimpan/men-cache versi data terbaru. Memberi tahu pengamat aktifnya saat
    // data telah berubah. Karena untuk mendapatkan semua isi database,
    // ada pemberitahuan setiap kali ada konten database yang berubah.
    @Query("SELECT * from word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): LiveData<List<Word>>

    // menambahkan dua item dengan kunci utama yang sama ke database. Jika tabel memiliki lebih dari satu
    // kolom, Anda dapat menggunakan @Insert(onConflict = OnConflictStrategy.REPLACE) untuk memperbarui baris.
    @Insert
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    fun deleteAll()
}
