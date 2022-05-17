import instance from "@/util/request";

export const GiveMeAllTableNumber = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/newWeiIs0",
        method: "post",
        data: params
    })
}

export const GiveMeUsingTableNumber = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/newWeiIs1",
        method: "post",
        data: params
    })
}

export const DoOverTimeCheck = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/chaoShiXG",
        method: "post",
        data: params
    })
}


export const ParseUserInfoToDataBase = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/newyongHuShuJuShuR",
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
        url: "http://127.0.0.1:8088/newgouWuCheChaRuList",
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

export const DoAddOrMinusFoodQuantity = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/newshuLiang",
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

export const DoDisplayDoneOrders = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/qDGouWuCheXS",
        method: "post",
        data: params
    })
}

export const DoSwitchStatus = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/wanChengZF",
        method: "post",
        data: params
    })
}

export const DoParseTableNumber = (params) => {
    return instance({
        url: "http://127.0.0.1:8088/huanGetWeiId",
        method: "post",
        data: params
    })
}
