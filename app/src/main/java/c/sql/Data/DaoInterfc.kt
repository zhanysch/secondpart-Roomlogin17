package c.sql.Data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao  //( эта функц делает запрос в базу данных)
interface DaoInterfc {

    @Insert //(позволяет вставить данные в базу данных)
    fun insertDataClassEdit(data: DataClassEdit) //(чтоб сохран передаем датакласс)

    @Query ("SELECT * FROM DATACLASSEDIT")      // <-это функц позволяет нам получить, сохраненн данные
    fun getallEditFromDataclass(): List<DataClassEdit> // <<DataClassEdit>  <- возвращает из дата класс
                                                        // из БД невозможно возваращать arralist^ поэтому List<DataClassEdit>
    @Delete
    fun delete(data: DataClassEdit)   // внутрь скобок вставл (data: DataClassEdit), тогда функц будет знать что удалить.

}