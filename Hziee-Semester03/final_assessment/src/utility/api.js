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

export const DoLoadParagraphCommentData = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/ParagraphComment",
		method: "post",
		data: params
	})
}

export const DoInsertNewCommentToDatabase = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/InsertNewCommentToDatabase",
		method: 'post',
		data: params
	})
}

export const DoViewQuestionList = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/ViewQuestionList",
		method: 'post',
		data: params
	})
}

export const DoViewQuestionAnswerList = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/ViewQuestionAnswerList",
		method: 'post',
		data: params
	})
}

export const DoLoadViewAnswerDetail = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/ViewAnswerDetail",
		method: 'post',
		data: params
	})
}

export const DoLoadAnswerCommentData = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/AnswerComment",
		method: 'post',
		data: params
	})
}

export const DoInsertNewCommentToDatabase2 = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/InsertNewCommentToDatabase2",
		method: 'post',
		data: params
	})
}

export const DoLoadAllUserInfo = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/AllUserInfo",
		method: 'post',
		data: params
	})
}

export const DoLoadAllParagraphInfo = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/AllParagraphInfo",
		method: 'post',
		data: params
	})
}

export const DoLoadAllQuestionInfo = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/AllQuestionInfo",
		method: 'post',
		data: params
	})
}

export const DoLoadAllAnswerInfo = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/AllAnswerInfo",
		method: 'post',
		data: params
	})
}

export const DoAdminDeleteUser = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/AdminDeleteUser",
		method: 'post',
		data: params
	})
}

export const DoAdminDeleteParagraph = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/AdminDeleteParagraph",
		method: 'post',
		data: params
	})
}

export const DoAdminDeleteQuestion = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/AdminDeleteQuestion",
		method: 'post',
		data: params
	})
}

export const DoAdminDeleteAnswer = (params) => {
	return instance({
		url: "http://127.0.0.1:8080/AdminDeleteAnswer",
		method: 'post',
		data: params
	})
}