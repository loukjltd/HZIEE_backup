import instance from "@/util/request";

export const ParseUserInfoToDataBase = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/yongHuShuJuShuR",
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

export const DoLoadUserInfo = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/yongHuShuJuXS",
        method: "post",
        data: params
    })
}

export const DoLoadShoppingCartData = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/qDGouWuCheXS",
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

// export const DoCalculateTotalPrice = (params) => {
//     return instance({
//         url: "http://127.0.0.1:8088/jieSuan",
//         method: "post",
//         data: params
//     })
// }
