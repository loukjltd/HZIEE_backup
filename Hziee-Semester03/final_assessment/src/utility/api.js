import instance from "@/utility/request";

export const DoLoadHomePageData = (params) => {
    return instance({
        url: "http://127.0.0.1:8080/HomePage",
        method: "post",
        data: params
    })
}

export const DoLoadHomePageData2 = (params) => {
    return instance({
        url: "http://127.0.0.1:8080/HomePage2",
        method: "post",
        data: params
    })
}

export const DoLoadParagraphData = (params) => {
    return instance({
        url: "http://127.0.0.1:8080/Paragraph",
        method: "post",
        data: params
    })
}

export const DoLoadQuestionData = (params) => {
    return instance({
        url: "http://127.0.0.1:8080/Question",
        method: "post",
        data: params
    })
}