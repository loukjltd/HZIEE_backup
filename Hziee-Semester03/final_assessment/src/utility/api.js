import instance from "@/utility/request";

export const DoLoadHomePageParagraphData = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/HomePageParagraph",
		method: "post",
		data: params
	})
}

export const DoLoadHomePageQuestionData = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/HomePageQuestion",
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

export const DoLoadLoggedUserInfoInCreatorCenter = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/Creator",
		method: "post",
		data: params
	})
}

export const DoCheckIfThereIsLoggedUser = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/Mine",
		method: "post",
		data: params
	})
}

export const DoLogInUser = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/MineLogIn",
		method: "post",
		data: params
	})
}

export const DoLogOutUser = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/MineLogOut",
		method: "post",
		data: params
	})
}