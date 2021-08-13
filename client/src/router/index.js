import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

// const routes = [
//   {
//     path: '/',
//     name: 'Home',
//     component: Home
//   },
//   {
//     path: '/about',
//     name: 'About',
//     // route level code-splitting
//     // this generates a separate chunk (about.[hash].js) for this route
//     // which is lazy-loaded when the route is visited.
//     component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
//   }
// ]

const routes = [{
        path: '*',
        redirect: { name: 'patient' }
    },
    {
        path: '/emergency',
        name: 'Emergency',
        component: () =>
            import ('@/pages/Emergency'),
        meta: {
            title: '会员中心'
        }
    },
    {
        path: '/emergency/detail',
        name: 'detail',
        component: () =>
            import ('@/pages/Emergency/detail'),
        meta: {
            title: '会员中心'
        }
    },


    {
        name: 'patient',
        path: '/patient',
        component: () =>
            import ('@/pages/patient'),
        meta: {
            title: '患者管理'
        }
    },
    {
        name: 'patient_add',
        path: '/patient/add',
        component: () =>
            import ('@/pages/patient/patient_add'),
        meta: {
            title: '新增患者'
        }
    },
    {
        name: 'patient_estimate_list',
        path: '/patient/estimate/:id',
        component: () =>
            import ('@/pages/patient/estimate_list'),
        meta: {
            title: '已评分列表'
        }
    },


    {
        name: 'esimate',
        path: '/esimate',
        component: () =>
            import ('@/pages/esimate'),
        meta: {
            title: '首页'
        }
    },
    {
        name: 'esimateAdd',
        path: '/esimate_add',
        component: () =>
            import ('@/pages/esimate/add'),
        meta: {
            title: '新增'
        }
    },
    {
        name: 'esimateDetail',
        path: '/esimate/edit',
        component: () =>
            import ('@/pages/esimate/edit'),
        meta: {
            title: '量表详情'
        }
    }
];

// add route path
routes.forEach(route => {
    route.path = route.path || '/' + (route.name || '');
});


const router = new VueRouter({
    routes
})

router.beforeEach((to, from, next) => {
    const title = to.meta && to.meta.title;
    if (title) {
        document.title = title;
    }
    next();
});

export default router