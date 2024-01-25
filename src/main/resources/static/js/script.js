const selectElement = document.getElementById("reserve_time");

// 開始時刻と終了時刻を設定
const startTime = 10;
const endTime = 22;

// 時間間隔を設定（分単位）
const interval = 30;

// 選択肢を生成
for (let hour = startTime; hour <= endTime; hour++) {
    for (let minute = 0; minute < 60; minute += interval) {
        const time = ("0" + hour).slice(-2) + ":" + ("0" + minute).slice(-2);
        const option = document.createElement("option");
        option.value = time; // value属性を設定
        option.text = time;
        selectElement.appendChild(option);
    }
}

// ページ読み込み時に実行
window.onload = function() {
	// 今日の日付を取得
	const today = new Date();
	const year = today.getFullYear();
	const month = today.getMonth() + 1;
	const day = today.getDate();

	// フォームの日付要素を取得
	const reserveDateInput = document.getElementById("reserve_date");

	// 日付を"yyyy-MM-dd"形式に整形
	const formattedDate = `${year}-${month.toString().padStart(2, "0")}-${day.toString().padStart(2, "0")}`;

	// 日付をフォームのvalue属性に設定
	reserveDateInput.value = formattedDate;
};