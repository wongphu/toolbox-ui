function helloJS() {
  return "Hello Javascript!"
}

function downloadBlob(blob, name) {
  const blobUrl = URL.createObjectURL(blob);
  const link = document.createElement("a");
  link.href = blobUrl;
  link.download = name;
  document.body.appendChild(link);
  const event = new MouseEvent('click', { bubbles: true, cancelable: true, view: window});
  link.dispatchEvent(event);
  document.body.removeChild(link);
}

function parseCsv(content) {
  const csv = Papa.parse(content.trim());
  return csv.data;
}

function makeCsv(rows) {
  return Papa.unparse(rows);
}

function copyToClipboard(id) {
  var r = document.createRange();
  r.selectNode(document.getElementById(id));
  window.getSelection().removeAllRanges();
  window.getSelection().addRange(r);
  document.execCommand('copy');
  window.getSelection().removeAllRanges();
}
