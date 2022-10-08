//输入的时间是'2022/3/11 12:00'这种格式
export const compareTime = (getTime) => {
	const today = new Date();  //获取当前时间
	getTime = getTime.replace(/-/g, '/');
	//转化成时间戳作比较
	const endTime = new Date(getTime); //自己的时间
	if (today.getTime() > endTime.getTime()) {
		//当前时间大于我的时间
		return false
	} else {
		//当前时间小于我的时间
		return true
	}
}

