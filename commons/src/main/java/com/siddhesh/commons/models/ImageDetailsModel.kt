package com.siddhesh.commons.models

import com.google.gson.annotations.SerializedName
import com.siddhesh.commons.utils.JsonKeys

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
)