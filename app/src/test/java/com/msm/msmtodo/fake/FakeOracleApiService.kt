package com.msm.msmtodo.fake

import com.msm.msmtodo.model.MsmResponse
import com.msm.msmtodo.network.OracleApiService

class FakeOracleApiService: OracleApiService {
    override suspend fun getOraData(): MsmResponse {
        return FakeDataSource.itemsFromDB
    }

}