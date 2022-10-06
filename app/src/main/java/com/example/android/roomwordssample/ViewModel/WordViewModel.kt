package com.example.android.roomwordssample.ViewModel


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.android.roomwordssample.Repository.WordRepository
import com.example.android.roomwordssample.Room.Word
import com.example.android.roomwordssample.Room.WordRoomDatabase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * View Model untuk menyimpan referensi ke repositori kata dan
 * daftar terkini dari semua kata.
 */

class WordViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WordRepository
    // Menggunakan LiveData dan menyimpan
    val allWords: LiveData<List<Word>>

    init {
        val wordsDao = WordRoomDatabase.getDatabase(application, viewModelScope).wordDao()
        repository = WordRepository(wordsDao)
        allWords = repository.allWords
    }

    /**
     * Meluncurkan coroutine baru untuk memasukkan data.
     */
    fun insert(word: Word) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(word)
    }
}
