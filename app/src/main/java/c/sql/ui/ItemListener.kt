package c.sql.ui

import c.sql.Data.DataClassEdit
import c.sql.Data.DataclassLogPass

interface ItemListener {
    fun itemClicked(data : DataClassEdit)

    fun itemClicks (data1 : DataclassLogPass)
}