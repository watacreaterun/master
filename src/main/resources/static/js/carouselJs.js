//document.addEventListener("DOMContentLoaded", function () {
//	const slides = document.querySelectorAll(".slide");
//	let slideIndex = 0;
//
//	function showSlide() {
//		slides.forEach((slide, i) => {
//			if (i === slideIndex) {
//				slide.classList.add("show");
//			} else {
//				slide.classList.remove("show");
//			}
//		});
//		updateIndicators();
//	}
//
//	function updateIndicators() {
//		const buttons = document.querySelectorAll(".indicator_button");
//		buttons.forEach((button, index) => {
//			if (index === slideIndex) {
//				button.classList.add("active");
//			} else {
//				button.classList.remove("active");
//			}
//		});
//	}
//
//	function nextSlide() {
//		slideIndex++;
//		if (slideIndex >= slides.length) {
//			slideIndex = 0;
//		}
//		showSlide();
//	}
//
//	// 初期表示
//	showSlide();
//
//	// 自動で次のスライドに切り替えるタイマー
//	setInterval(nextSlide, 5000);
//});
