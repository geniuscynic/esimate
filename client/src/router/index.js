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
        name: 'patient',
        path: '/patient',
        component: () =>
            import ('@/pages/patient'),
        meta: {
            title: '患者管理'
        },

    },

    {
        name: 'patient_add',
        path: '/patient/add',
        component: () =>
            import ('@/pages/patient/add'),
        meta: {
            title: '新增患者'
        }
    },

    {
        name: 'estimate',
        //path: '/patient/:id/estimate',
        path: '/estimate',
        component: () =>
            import ('@/pages/estimate/index'),
        meta: {
            title: '已评分列表'
        }
    },

    
    {
        name: 'esimate_list',
        //path: '/patient/:id/esimate/list',
        path: '/esimate/list',
        component: () =>
            import ('@/pages/estimate/list'),
        meta: {
            title: '所有量表列表'
        }
    },

    {
        name: 'estimate_add',
        //path: '/patient/:id/estimate/add/:code',
        path: '/estimate/add/:code',
        component: () =>
            import ('@/pages/estimate/add'),
        meta: {
            title: '新增'
        }
    },

    {
        name: 'estimate_edit',
        path: '/estimate/edit/:id',
        component: () =>
            import ('@/pages/estimate/edit'),
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