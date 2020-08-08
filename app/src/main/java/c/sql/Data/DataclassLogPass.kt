package c.sql.Data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class DataclassLogPass (
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var edlog: String,
    var edpass: String

)