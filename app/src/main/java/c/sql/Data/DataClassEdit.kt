package c.sql.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity  // ( заметки для себя) .Entity позволяет создать таблицу, для библиотеки Room из (!) переменок)
data class DataClassEdit (
    @PrimaryKey(autoGenerate = true) // (ключ будет генерировать по id таблицы)
    val id: Int= 0,
    var edtOne : String, //(!)
    var edtTwo : String //(2)
 )