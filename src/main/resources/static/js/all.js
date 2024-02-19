const $addBtn = document.getElementById('addBtn');
  $addBtn.addEventListener('click', evt=>{
    location.href = '/forums/add';              // GET http://localhost:9080/products/add
  });

const $rows = document.getElementById('rows');
$rows.addEventListener('click',evt=>{
  const $row = evt.target.closest('.row');
  const boardId = $row.dataset.boardId;
  location.href = `/forums/${boardId}/detail`;
});
