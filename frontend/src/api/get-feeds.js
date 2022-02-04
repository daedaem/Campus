const getFeeds = (number) => {
  let ret = [];

  for (var i = 0; i < number; i++) {
    ret.push({
      author: names[i % names.length],
      content: "",
    });
  }
};

export default getFeeds;
