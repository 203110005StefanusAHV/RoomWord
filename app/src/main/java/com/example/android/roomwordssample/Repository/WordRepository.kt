package com.example.android.roomwordssample.Repository

import androidx.lifecycle.LiveData
import androidx.annotation.WorkerThread
import com.example.android.roomwordssample.Room.Word
import com.example.android.roomwordssample.Room.WordDao

class WordRepository(private val wordDao: WordDao) {

    // Room mengeksekusi semua kueri pada utas terpisah.
    val allWords: LiveData<List<Word>> = wordDao.getAlphabetizedWords()

    // memnanggil ini di utas non-UI agar aplikasi tidak berhenti
    @WorkerThread
    suspend fun insert(word: Word) {
        wordDao.insert(word)
    }
}
