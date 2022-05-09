import instance from "@/util/request";

export const DoSaveOrderNumber0 = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/CaiPinDingId",
        method: "post",
        data: params
    })
}

export const DoSaveOrderNumber1 = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/GouWuCheDingId",
        method: "post",
        data: params
    })
}

export const DoSaveOrderNumber2 = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/YongHuDingId",
        method: "post",
        data: params
    })
}

export const DoSaveOrderNumber3 = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/ZhuangTaiDingId",
        method: "post",
        data: params
    })
}

export const ParseUserInfoToDataBase = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/yongHuShuJuShuR",
        method: "post",
        data: params
    })
}




export const DoCheckTime = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/chaoShiXG",
        method: "post",
        data: params
    })
}

export const DoOverTimeCheck = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/choShiJC",
        method: "post",
        data: params
    })
}

export const DoLoadCategoryData = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/fenLei",
        method: "post",
        data: params
    })
}

export const DoLoadFoodData = (params) => {
  return instance({
      url: "http://127.0.0.1:8088/caiPinBiao",
      method: "post",
      data: params
  })
}

export const DoAddFood = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/gouWuCheChaRuList",
        method: "post",
        data: params
    })
}

// export const DoLoadUserInfo = (params) => {
//     return instance({
//         url: "http://127.0.0.1:8088/yongHuShuJuXS",
//         method: "post",
//         data: params
//     })
// }

export const DoLoadShoppingCartData = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/qDGouWuCheXS",
        method: "post",
        data: params
    })
}

export const DoLoadShoppingCartData2 = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/qD2GouWuCheXS",
        method: "post",
        data: params
    })
}


export const DoAddOrMinusFoodQuantity = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/shuLiang",
        method: "post",
        data: params
    })
}

export const FinishPayment = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/wanChengZF",
        method: "post",
        data: params
    })
}

export const DoCalculateTotalPrice = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/wcDingDaiShuJuXS",
        method: "post",
        data: params
    })
}
