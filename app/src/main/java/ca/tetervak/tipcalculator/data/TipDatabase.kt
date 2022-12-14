package ca.tetervak.tipcalculator.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

// Annotates class to be a Room Database with a table (entity) of the Word class
@Database(entities = [TipDataEntity::class], version = 1, exportSchema = false)
@TypeConverters(DataConverters::class)
abstract class TipDatabase : RoomDatabase() {

    abstract fun tipDataDao(): TipDataDao
}