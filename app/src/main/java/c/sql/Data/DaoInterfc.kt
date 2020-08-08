package c.sql.Data

import androidx.room.*

@Dao  //( эта функц делает запрос в базу данных)
interface DaoInterfc {

    @Insert //(позволяет вставить данные в базу данных)
    fun insertDataClassEdit(data: DataClassEdit) //(чтоб сохран передаем датакласс)

    @Query ("SELECT * FROM DATACLASSEDIT")      // <-это функц позволяет нам получить, сохраненн данные
    fun getallEditFromDataclass(): List<DataClassEdit> // <<DataClassEdit>  <- возвращает из дата класс
                                                        // из БД невозможно возваращать arralist^ поэтому List<DataClassEdit>
    @Delete
    fun delete(data: DataClassEdit)   // внутрь скобок вставл (data: DataClassEdit), тогда функц будет знать что удалить.

    @Insert(onConflict = OnConflictStrategy.REPLACE) //чтоб данные при лог и пасс не совпадали REPLACE будет изменять лог пасс
    fun saveforScreenLogPAss(logpasss : DataclassLogPass)

    @Query ("SELECT * FROM DataclassLogPass")
    fun getEditfromdata(): List<DataclassLogPass>

    @Query("SELECT * FROM DataclassLogPass WHERE edlog = :loginT AND edpass= :passwordT")
    fun getUSer(loginT:String, passwordT:String):DataclassLogPass

    @Delete
    fun delete2(data2 : DataclassLogPass)


}