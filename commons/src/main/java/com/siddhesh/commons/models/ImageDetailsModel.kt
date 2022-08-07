package com.siddhesh.commons.models

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.siddhesh.commons.utils.JsonKeys
import java.text.SimpleDateFormat
import java.util.*


data class ImageDetailsModel(

    @SerializedName(JsonKeys.KEY_COPY_RIGHTS)
    var copyRight: String? = "",
    @SerializedName(JsonKeys.KEY_DATE)
    var date: String? = "",
    @SerializedName(JsonKeys.KEY_EXPLANATION)
    var explanation: String? = "",
    @SerializedName(JsonKeys.KEY_HD_URL)
    var hdURL: String? = "",
    @SerializedName(JsonKeys.KEY_MEDIA_TYPE)
    var mediaType: String? = "",
    @SerializedName(JsonKeys.KEY_SERVICE_VERSION)
    var serviceVersion: String? = "",
    @SerializedName(JsonKeys.KEY_TITLE)
    var title: String? = "",
    @SerializedName(JsonKeys.KEY_URL)
    var url: String? = ""
) : Parcelable {

    fun getParsedDate():Date{
       return SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).parse(date)
    }
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun describeContents(): Int {
        return 0
    }


    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(copyRight)
        dest.writeString(date)
        dest.writeString(explanation)
        dest.writeString(hdURL)
        dest.writeString(mediaType)
        dest.writeString(serviceVersion)
        dest.writeString(title)
        dest.writeString(url)
    }

    companion object CREATOR : Parcelable.Creator<ImageDetailsModel> {
        override fun createFromParcel(parcel: Parcel): ImageDetailsModel {
            return ImageDetailsModel(parcel)
        }

        override fun newArray(size: Int): Array<ImageDetailsModel?> {
            return arrayOfNulls(size)
        }
    }
}