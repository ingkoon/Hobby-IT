module.exports = {
  root: true,
  env: {
    node: true,
  },
  extends: ['eslint:recommended', 'plugin:vue/vue3-recommended', 'prettier'],
  rules: {
    'no-unused-vars': 'off',
    'vue/multi-word-component-names': [
      'error',
      {
        ignores: [],
      },
    ],
  },
};
