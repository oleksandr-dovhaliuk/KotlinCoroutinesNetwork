package com.oleksandrdovhaliuk.corotinesnetwork.data.network

import com.oleksandrdovhaliuk.corotinesnetwork.data.network.dto.RecipeDto
import com.oleksandrdovhaliuk.corotinesnetwork.data.network.dto.RecipeQueryResponse
import com.oleksandrdovhaliuk.corotinesnetwork.data.preference.PrefHelper

class NetworkManager(
    private val recipeApi: RecipeApi,
    prefManager: PrefHelper
) : NetworkHelper {

    private var authToken: String = prefManager.getAuthToken()

    override suspend fun findRecipe(query: String): RecipeQueryResponse {
        return recipeApi.findRecipe(authToken, query)
    }

    override suspend fun getRecipeById(id: Int): RecipeDto {
        return recipeApi.getRecipeById(authToken, id)
    }
}