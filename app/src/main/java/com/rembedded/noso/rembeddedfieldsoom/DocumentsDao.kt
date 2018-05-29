package com.rembedded.noso.rembeddedfieldsoom

import android.arch.persistence.room.*
@Dao
interface DocumentsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertDocument(documentLocal: DocumentLocal)

    @Query("SELECT * FROM $DOCUMENT_TABLE WHERE ${DocumentLocal.ID} = :id")
    fun getDocumentsById(id: String): DocumentLocal

}