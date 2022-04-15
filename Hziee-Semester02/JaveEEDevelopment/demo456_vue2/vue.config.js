// const { defineConfig } = require('@vue/cli-service')
// module.exports = defineConfig({
//   transpileDependencies: true
// })

module.exports = {
  devServer: {
    port: 8080,
    host: '127.0.0.1',
    open: true,
    https: false,
    proxy: {
      '/BossWebApi': {
        target: 'http://127.0.0.1:8080/',
        changeOrigin: true,
        pathRewrite: {
          '^/BossWebApi': ''
        }
      },
    }
  },
}