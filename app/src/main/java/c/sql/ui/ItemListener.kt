package c.sql.ui

import c.sql.Data.DataClassEdit

interface ItemListener {
    fun itemClicked(data : DataClassEdit)
}