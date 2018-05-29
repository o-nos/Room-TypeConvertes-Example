package com.rembedded.noso.rembeddedfieldsoom

import android.arch.persistence.room.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken


const val DOCUMENT_TABLE = "document"


@Entity(tableName = DOCUMENT_TABLE)
data class DocumentLocal(@PrimaryKey @ColumnInfo(name = ID) var id: String = "",
                         var name: String = "",
                         @TypeConverters(DataConverter::class)
                         var fields: MutableList<Field>? = mutableListOf()) {
    companion object {
        const val ID = "id"
    }



}

class DataConverter {

    @TypeConverter
    fun fromFieldMutableList(countryLang: MutableList<Field>?): String? {
        if (countryLang == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<MutableList<Field>>() {

        }.type
        return gson.toJson(countryLang, type)
    }

    @TypeConverter
    fun toFieldMutableList(countryLangString: String?): MutableList<Field>? {
        if (countryLangString == null) {
            return null
        }
        val gson = Gson()
        val type = object : TypeToken<MutableList<Field>>() {

        }.type
        return gson.fromJson<MutableList<Field>>(countryLangString, type)
    }

}
