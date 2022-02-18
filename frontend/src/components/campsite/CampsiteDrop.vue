<template>
  <nav class="navbar navbar-expand-lg">
    <div class="container-fluid">
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#main_nav"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="main_nav">
        <ul class="navbar-nav">
          <li class="nav-item dropdown" id="myDropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              data-bs-toggle="dropdown"
            >
              {{ selected }}
            </a>
            <ul class="dropdown-menu">
              <li>
                <a class="dropdown-item" href="#"> Dropdown item 1 </a>
              </li>
              <li>
                <a class="dropdown-item" href="#">
                  div Dropdown item 2 &raquo;
                </a>
                <ul class="submenu dropdown-menu">
                  <li><a class="dropdown-item" href="#">Submenu item 1</a></li>
                  <li><a class="dropdown-item" href="#">Submenu item 2</a></li>
                  <li>
                    <a class="dropdown-item" href="#"
                      >Submenu item 3 &raquo;
                    </a>
                    <ul class="submenu dropdown-menu">
                      <li>
                        <a class="dropdown-item" href="#">Multi level 1</a>
                      </li>
                      <li>
                        <a class="dropdown-item" href="#">Multi level 2</a>
                      </li>
                    </ul>
                  </li>
                  <li><a class="dropdown-item" href="#">Submenu item 4</a></li>
                  <li><a class="dropdown-item" href="#">Submenu item 5</a></li>
                </ul>
              </li>
              <li><a class="dropdown-item" href="#"> Dropdown item 3 </a></li>
              <li><a class="dropdown-item" href="#"> Dropdown item 4 </a></li>
            </ul>
          </li>
        </ul>
      </div>
      <!-- navbar-collapse.// -->
    </div>
    <!-- container-fluid.// -->
  </nav>
  <!-- <b-dropdown
      size="lg"
      variant="white"
      toggle-class="text-decoration-none"
      no-caret
    >
      <template #button-content
        >지역
        <div class="sr-only"></div>
      </template> 
    <b-dropdown-item-button>게시물 상세보기</b-dropdown-item-button>
    <b-dropdown-item-button variant="danger" text="Outline Danger"
    >삭제</b-dropdown-item-button
    

    <b-form-group v-slot="{ ariaDescribedby }">
        <b-form-checkbox-group
          id="checkbox-group-1"
          v-model="selected"
          :options="options"
          :aria-describedby="ariaDescribedby"
          name="positionSelection"
        ></b-form-checkbox-group>
      </b-form-group>
      <b-dropdown-item-button>취소</b-dropdown-item-button>
    </b-dropdown> -->

  <!-- <input type="checkbox" /> -->
  <!-- 
    <b-dropdown
      size="lg"
      variant="link"
      toggle-class="text-decoration-none"
      no-caret
    >
      <template #button-content>
        &#x1f50d;<span class="sr-only">Search</span>
      </template>
      <b-dropdown-item href="#"> li li{{ this.do.item }} </b-dropdown-item>
      <b-dropdown-item href="#">Another action</b-dropdown-item>
      <b-dropdown-item href="#">Something else here...</b-dropdown-item>
    </b-dropdown>
  </div> -->
</template>

<script>
import axios from "axios";
const SERVER_URL = process.env.VUE_APP_SERVER_URL;
document.addEventListener("DOMContentLoaded", function () {
  // make it as accordion for smaller screens
  if (window.innerWidth < 992) {
    // close all inner dropdowns when parent is closed
    document
      .querySelectorAll(".navbar .dropdown")
      .forEach(function (everydropdown) {
        everydropdown.addEventListener("hidden.bs.dropdown", function () {
          // after dropdown is hidden, then find all submenus
          this.querySelectorAll(".submenu").forEach(function (everysubmenu) {
            // hide every submenu as well
            everysubmenu.style.display = "none";
          });
        });
      });

    document.querySelectorAll(".dropdown-menu a").forEach(function (element) {
      element.addEventListener("click", function (e) {
        let nextEl = this.nextElementSibling;
        if (nextEl && nextEl.classList.contains("submenu")) {
          // prevent opening link if link needs to open dropdown
          e.preventDefault();
          if (nextEl.style.display == "block") {
            nextEl.style.display = "none";
          } else {
            nextEl.style.display = "block";
          }
        }
      });
    });
  }
  // end if innerWidth
});
export default {
  name: "CampsiteDrop",
  data() {
    return {
      doname: "",
      do: {
        item: "지역",
        dosub: [
          { item: "강원도", subitems: [{ item: "~~" }] },
          { item: "경기도", subitems: [{ item: "~~" }] },
          { item: "경상남도", subitems: [{ item: "~~" }] },
        ],
      },

      selected: [], // Must be an array reference!
      options: [
        { text: "강원도", value: "강원도" },
        { text: "경기도", value: "경기도" },
        { text: "서울시", value: "서울시" },
        { text: "충청북도", value: "충청북도" },
        { text: "충청남도", value: "충청남도" },
        { text: "대전시", value: "대전시" },
        { text: "전라북도", value: "전라북도" },
        { text: "전라남도", value: "전라남도" },
        { text: "인천시", value: "인천시" },
        { text: "세종시", value: "세종시" },
        { text: "경상북도", value: "경상북도" },
        { text: "경상남도", value: "경상남도" },
        { text: "광주시", value: "광주시" },
        { text: "대구시", value: "대구시" },
        { text: "부산시", value: "부산시" },
        { text: "울산시", value: "울산시" },
        { text: "제주도", value: "제주도" },
      ],
    };
  },
  created: function () {
    axios({
      methods: "get",
      url: `${SERVER_URL}/camp/do`,
      // params: { searchWord: "#" + this.inputData },
    }).then((res) => {
      // articles.value.push(...res.data.list);
      // this.searchResults = res.data.list;
      this.doname = res;
      console.log("있는데", res);
      //   this.$store.dispatch("searchData", "#" + this.inputData);
      //   this.$store.dispatch("searchResult", res.data.list);
      // });
    });
  },
};
</script>

<style>
.CampsiteDropFrame {
  width: 150px;
  height: 150px;
  background: #fff;
}
@media all and (min-width: 992px) {
  .dropdown-menu li {
    position: relative;
  }
  .nav-item .submenu {
    display: none;
    position: absolute;
    left: 100%;
    top: -7px;
  }
  .nav-item .submenu-left {
    right: 100%;
    left: auto;
  }
  .dropdown-menu > li:hover {
    background-color: #f1f1f1;
  }
  .dropdown-menu > li:hover > .submenu {
    display: block;
  }
}
/* ============ desktop view .end// ============ */

/* ============ small devices ============ */
@media (max-width: 991px) {
  .dropdown-menu .dropdown-menu {
    margin-left: 0.7rem;
    margin-right: 0.7rem;
    margin-bottom: 0.5rem;
  }
}
</style>
