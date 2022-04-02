import instance from "@/util/request";
export const LoadingPdfTrayCodes = (params) => {
    return instance({
        url: "http://127.0.0.1:8080/loadingPdfTrayCodes",
        method: "post",
        data: params
    })
}

export const scanATrayCode = (params) => {
    return instance({
        url: "http://127.0.0.1:8080/scanATrayCode",
        method: "post",
        data: params
    })
}
