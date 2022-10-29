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

export const DoRegisterAccount = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/MineRegister",
		method: "post",
		data: params
	})
}

export const DoLoadTaskInfo = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/Task",
		method: "post",
		data: params
	})
}

export const DoEveryDaySignIn = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/MineEverydaySignIn",
		method: "post",
		data: params
	})
}

export const DoParseTaskContent = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/TaskUpdateStatus",
		method: "post",
		data: params
	})
}

export const DoTaskUpdateUserCoin = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/TaskUpdateUserCoin",
		method: "post",
		data: params
	})
}

export const DoInsertQuestionToDatabase = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/InsertQuestionToDatabase",
		method: "post",
		data: params
	})
}

export const DoInsertParagraphToDatabase = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/InsertParagraphToDatabase",
		method: "post",
		data: params
	})
}

export const DoInsertRelatedTaskWithNewUser = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/InsertRelatedTaskWithNewUser",
		method: "post",
		data: params
	})
}

export const DoViewParagraphDetail = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/ViewParagraphDetail",
		method: "post",
		data: params
	})
}