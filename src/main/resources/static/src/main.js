'use strict';

// Header에 페이지 아래로 스크롤시 다크 스타일링 적용
const header = document.querySelector('.header');
const headerHeight = header.offsetHeight;
document.addEventListener('scroll', () => {
  if (window.scrollY > headerHeight) {
    header.classList.add('header--dark');
  } else {
    header.classList.remove('header--dark');
  }
});

// Home 섹션을 아래로 스크롤시 투명하게 처리함
const home = document.querySelector('.home__container');
const homeHeight = home.offsetHeight;
document.addEventListener('scroll', () => {
  home.style.opacity = 1 - window.scrollY / homeHeight;
});

// Arrow up버튼을 아래로 스크롤시 투명하게 처리함
const arrowUp = document.querySelector('.arrow-up');
document.addEventListener('scroll', () => {
  if (window.scrollY > homeHeight / 2) {
    arrowUp.style.opacity = 1;
  } else {
    arrowUp.style.opacity = 0;
  }
});

// Navbar 토글버튼 클릭 처리
const navbarMenu = document.querySelector('.header__menu');
const navbarToggle = document.querySelector('.header__toggle');
navbarToggle.addEventListener('click', () => {
  navbarMenu.classList.toggle('open');
});

// Navbar 메뉴 클릭시 메뉴를 자동으로 닫아줌
navbarMenu.addEventListener('click', () => {
  navbarMenu.classList.remove('open');
});


document.addEventListener('DOMContentLoaded', () => {
  const notices = [
    { title: 'Notice 1', content: 'This is the content of notice 1.' },
    { title: 'Notice 2', content: 'This is the content of notice 2.' },
    { title: 'Notice 3', content: 'This is the content of notice 3.' }
  ];

  const noticeList = document.getElementById('notice-list');
  const searchForm = document.getElementById('search-form');
  const searchInput = document.getElementById('search-input');
  const addNoticeForm = document.getElementById('add-notice-form');
  const newTitle = document.getElementById('new-title');
  const newContent = document.getElementById('new-content');

  const displayNotices = (notices) => {
    noticeList.innerHTML = '';
    notices.forEach(notice => {
      const li = document.createElement('li');
      li.innerHTML = `<h3>${notice.title}</h3><p>${notice.content}</p>`;
      noticeList.appendChild(li);
    });
  };

  const filterNotices = (query) => {
    return notices.filter(notice => {
      return notice.title.toLowerCase().includes(query.toLowerCase()) ||
             notice.content.toLowerCase().includes(query.toLowerCase());
    });
  };

  searchForm.addEventListener('submit', (event) => {
    event.preventDefault();
    const query = searchInput.value;
    const filteredNotices = filterNotices(query);
    displayNotices(filteredNotices);
  });

  addNoticeForm.addEventListener('submit', (event) => {
    event.preventDefault();
    const title = newTitle.value;
    const content = newContent.value;
    if (title && content) {
      notices.push({ title, content });
      displayNotices(notices);
      newTitle.value = '';
      newContent.value = '';
    }
  });

  displayNotices(notices); // 초기 공지사항 표시
});

// guide.
function initMap() {
  const center = { lat: 37.5665, lng: 126.9780 }; // 서울의 예시 좌표
  const map = new google.maps.Map(document.getElementById('map'), {
      zoom: 15,
      center: center
  });
  const marker = new google.maps.Marker({
      position: center,
      map: map,
      title: '박람회 장소'
  });
}

document.addEventListener('DOMContentLoaded', function() {
  const script = document.createElement('script');
  script.src = `https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&callback=initMap`;
  script.async = true;
  document.head.appendChild(script);
});
