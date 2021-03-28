package com.oleksandrdovhaliuk.corotinesnetwork.data.network.dto

import com.google.gson.annotations.SerializedName

data class RecipeQueryResponse(
    @SerializedName("count") val count: Int,
    @SerializedName("next") var nextPageUrl: String? = null,
    @SerializedName("previous") var previousPageUrl: String? = null,
    @SerializedName("results") val results: List<RecipeDto>
)