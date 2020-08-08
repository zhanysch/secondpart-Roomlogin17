package c.sql.Data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [DataClassEdit::class, DataclassLogPass::class],  version = 1)  // (указываем в этом классе название таблицы в dataclass и версию БД)
abstract class DataBaseAbstrct:RoomDatabase() {
    abstract fun getDaoInterf():DaoInterfc  // <-возврат тип данных интерфейс
}