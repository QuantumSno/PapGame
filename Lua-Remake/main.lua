require "player"

function love.load()
    _G.player = loadPlayer()
    local _, _, flags = love.window.getMode()
    width, height = love.window.getDesktopDimensions(flags.display)
    love.graphics.setDefaultFilter('nearest', 'nearest')
    love.window.setFullscreen(true)
end

function love.update(dt) _G.player:update() end

function love.draw() _G.player:draw() end

function love.keypressed(key, scancode, isrepeat)
    if key == "escape" then love.event.quit() end
end
